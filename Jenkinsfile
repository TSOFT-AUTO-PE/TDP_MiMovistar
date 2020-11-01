pipeline {
     parameters {
      string(name: 'NODE_NAME', defaultValue: '', description: 'Enter the name of the node for the execution')
      string(name: 'DATA_FILE', defaultValue: 'C:\\DATA_Jenkins\\TDP_MiMovistar_Recarga_Web', description: 'Enter the Path of the DATA ENTRY, this must be in the NODE')
      //string(name: 'TEST_TAG', defaultValue: 'mvn test -Dcucumber.options="--tags ', description: 'This parameter is STATIC, do not Change')
      //string(name: 'COPY_DESC', defaultValue: '.\\src\\main\\resources\\excel', description: 'Change backslash')
     }

      agent {
             node { label "${params.NODE_NAME}"}
         }

   stages {

     /*stage('Building') {
            steps {
               // Get some code from a GitHub repository
               echo 'Creando WorkSpace'
               }
           }*/

              stage('Clean the Script') {
                    steps {
                    bat 'mvn clean'
                    }
              }

                      stage('Update DATA') {
                            steps {
                            script {
                            def body = '.\\src\\main\\resources\\excel\\TDP_MiMovistar_Recarga_Web'
                            bat "xcopy /s ${params.DATA_FILE} ${body} /y"
                            }
                            }
                      }

        stage('Especify the TAG and Run Test') {
                            steps {
                                script {
                                    def mvnVariable = 'mvn test -Dcucumber.options="--tags '
                                    def userInputTxt = input(
                                                        id: 'inputTAG', message: 'Please enter mvn TAG Description', parameters: [
                                                        [$class: 'TextParameterDefinition', description: 'Input the TAG for Execution ',name: 'Input']
                                                       ])
                                       echo ("The TAG Test Running is: ${userInputTxt}")
                                       bat "${mvnVariable}${userInputTxt}"

                                }
                                }
                           }

                           stage('Run Static Analysis with SonarQ') {
                                               steps {
                                               script{
                                                   withSonarQubeEnv('sonarserver') {
                                                                        bat "mvn sonar:sonar"
                                                                       }
                                                              //         timeout(time: 1, unit: 'HOURS'){
                                                                //       def qg = waitForQualityGate()
                                                                    //       if(qg.status != 'OK'){
                                                                       //    error "Pipeline aborted due to Quality gate failure: ${qg.status}"
                                                                      //     }
                                                                    //   }

                                               }

                                               }
                                         }
       /*   stage('Running the Test') {
                             steps {
                                bat "${userInputTxt}"
                             }
                       }*/

        stage('Archive Results WORD') {
            steps {
            archiveArtifacts 'target/resultado/*.docx'
            }
      }

       stage('Archive Results IMG') {
             steps {
      		 archiveArtifacts 'target/resultado/img/**/*.*'
                  }
            }
      stage('Archive Results HTML') {
            steps {
		    archiveArtifacts 'target/resultado/frontend-reporte.html'
            }
      }
      stage('Archive Results EXCEL') {
                  steps {
      		    archiveArtifacts 'src/main/resources/excel/*.*'
                  }
            }
      stage('Cleaning WS') {
            steps {
            dir('target') {
                deleteDir()
                }
                                 dir('img') {
                                                deleteDir()
                                                }

            }
      }
    }
}
