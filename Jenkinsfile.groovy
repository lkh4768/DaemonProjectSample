node {
	stage('Init') {
		gradle = tool 'gradle'
	}
	stage('Checkout') {
		// Get some code from a Git repository
		checkout scm
	}
	stage('Doxygen') {
		sh "doxygen"
	}

	stage('Build') {
		sh "${gradle}/bin/gradle jar"
	}

	stage('Code Analytics') {
		withSonarQubeEnv('sonarqube-env') {
			sh "${gradle}/bin/gradle --info sonarqube"

		}
	}

	stage("Sleep"){
		sleep 30
	}

	stage("Quality Gate"){
		timeout(time: 1, unit: 'MINUTES') {
			def qg = waitForQualityGate()
				if (qg.status != 'OK') {
					error "Pipeline aborted due to quality gate failure: ${qg.status}"
				}
		}
	}

	stage('Deploy') {
		sh "docker build -t sample-daemon ."
		sh "docker run -d --name sample-daemon sample-daemon"
	}
}
