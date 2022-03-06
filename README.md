# Jenkins

Basic overview

Application types and walkthrough

Why Build

what goes under the hood

Pipelines


# BASIC OVERVIEW
''''''''''''''''''''''''''''''''''''''''''

# To install Jenkins in Ubuntu server follow the below commands:-

sudo apt update

sudo apt search openjdk

sudo apt update

sudo apt search openjdk

sudo apt install openjdk-11-jdk

java –version

curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null 
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null

apt upgrade -y

apt update -y
 
apt install jenkins -y

# Linux /RHEL

sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo

sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key

sudo yum install epel-release

#If epel release is failed make sure to install it before proceeding

#Make sure java 11 is installed by running java --version

sudo yum install java-11-openjdk-devel

sudo yum install Jenkins

if you face difficulty installing epel release then follow below instructions

vim /etc/yum.repos.d/epelfordaemonize.repo

[daemonize]
baseurl=https://download-ib01.fedoraproject.org/pub/epel/7/x86_64/
gpgcheck=no
enabled=yes

yum install daemonize
sudo apt-get update
sudo apt-get install jenkins -y
sudo apt upgrade
sudo apt install chkconfig java-devel -y
sudo apt install jenkins -y
sudo systemctl daemon-reload
sudo systemctl start jenkins
sudo systemctl status jenkins

Browse to http://localhost:8080 (or whichever port you configured for Jenkins when installing it) and wait until the Unlock Jenkins page appears.pt install openjdk-11-jdk
The command: sudo cat /var/lib/jenkins/secrets/initialAdminPassword will print the password at console.








# What is Jenkins?
Jenkins is a self-contained, open source automation server which can be used to automate all sorts of tasks related to building, testing, and delivering or deploying software.

# How Jenkins works

Jenkins runs as a server on a variety of platforms including Windows, MacOS, Unix variants and especially, Linux. To operate Jenkins, pipelines are created. A pipeline is a series of steps the Jenkins server will take to perform the required tasks of the CI/CD process. These are stored in a plain text Jenkinsfile. The Jenkinsfile uses a curly bracket syntax that looks similar to JSON. Steps in the pipeline are declared as commands with parameters and encapsulated in curly brackets. The Jenkins server then reads the Jenkinsfile and executes its commands, pushing the code down the pipeline from committed source code to production runtime. A Jenkinsfile can be created through a GUI or by writing code directly.

# Plugins
A plugin is an enhancement to the Jenkins system. They help extend Jenkins capabilities and integrated Jenkins with other software. Plugins can be downloaded from the online Jenkins Plugin repository and loaded using the Jenkins Web UI or CLI. Plugins help to integrate other developer tools into the Jenkins environment, add new user interface elements to the Jenkins Web UI, help with administration of Jenkins, and enhance Jenkins for build and source code management. One of the more common uses of plugins is to provide integration points for CI/CD sources and destinations.

# Security
Jenkins security revolves around securing the server and the user. Server security is achieved in the same way any other server is secured. Access to where it resides, such as a VM or bare metal server, is configured to allow for the fewest number of processes to communicate with the server. This is accomplished through typical server OS and networking security features. 
Jenkins also supports security for its internal user database. These features are accessed via the Jenkins Web UI. Jenkins supports two security realms: the Security Realm and the Authorization Realm. The Security Realm allows an operator to decide who has access to Jenkins and the Authorization Realm determines what they can do with that access.

# Managing Jenkins
Most standard administrative tasks can be performed from the screens in the Manage Jenkins section of the dashboard.
Discover, Install and Manage Plugins
Jenkins has hundreds of useful plugins. Plugins will eliminate the need to create custom scripting to solve common problems with minimal pain. Just remember plugins change often and become fragile. Minimize your plugin usage if possible.
Steps
1.	Navigate to Jenkins Web Interface > Login as Admin > Manage Jenkins > Manage Plugins > Available (Tab)
 
2.	Select checkbox for all the plugins you want to install
 
3.	Select "Download now and install after restart" at the bottom of the page.
4.	After Jenkins finishes restarting, the installed plugins will appear under Manage Plugins > Installed (Tab)

Here are a few Jenkins plugin recommendations:
•	Git - allows you to integrate GitHub to clone repository
•	GitHub Pull Request Builder - builds pull requests in GitHub and reports results
•	Swarm - enables slaves to auto-discover nearby Jenkins master and join it automatically
•	Sauce OnDemand - allows you to integrate Sauce Labs Selenium testing with Jenkins
•	Pipeline - suite of plugins that lets you orchestrate automation, simple or complex
•	Slack - allows posting of build notifications to a Slack channel
•	Thinbackup - simply backs up the global and job-specific configurations



# Configure Global Settings
Straight out of the box Jenkins will allow anyone to run anything as a user of Jenkins along with admin permissions, which is bad. I suggest enabling Lightweight Directory Access Protocol (LDAP), wich allows you to use corporate service. Users can log into Jenkins with their usual company login credentials.
Steps
1.	Navigate to Jenkins Web Interface > Login as Admin > Manage Jenkins > Configure Global Security
2.	Select checkbox to enable security.

 

3.	Set TCP port for JNLP slave agents to 9000.
4.	Select LDAP from the Access Control (Security Realm) section and enter your LDAP server address:

 

5.	Select matrix-based security from the Access Control (Authorization) section
6.	Select the checkbox for Prevent Cross Site Request Forgery Exploits, and Enable Slave --> Master Access Control



# Global Tool Configuration
On the Jenkins dashboard, select manage Jenkins, and then global tool configuration. On this page, you can configure Jenkins to manage several tools, including Java, Git, Maven and more.

1.	Global Tool Configuration
	Click the "Manage Jenkins" link.

	Click the "Global Tool Configuration" link.


 

2.	JDK
To add a new JDK installation, Click the "Add JDK" button.
Set the following properties:

	Uncheck "Install automatically"
	Name: openjdk-11.0.2_linux-x64
	JAVA_HOME: /opt/openjdk-11.0.2_linux-x64

 




3.	SonarQube Scanner
4.	To add new SonarQube Scanner installation, Click the "Add SonarQube Scanner" button.
Set the following properties:

	Uncheck "Install automatically"
	Name: SonarQube-Scanner
	SONAR_RUNNER_HOME: /opt/sonar-scanner

 

5.	Maven
To add a new Maven installation, Click the "Add Maven" button.
Set the following properties:

	Uncheck "Install automatically"
	Name: apache-maven
	MAVEN_HOME: /opt/apache-maven

 


# What is Jenkins URL?
This option, by default, depicts the HTTP address of Jenkins installation in the form of localhost i.e. http://localhost:8080/jenkins/. We can write DNS (Domain Name) of our machine or overwrite the localhost with the IP address of the machine. This value lets Jenkins know how to refer to itself, i.e. to display images or to create links in emails.  

What are the Environment variables in Jenkins?
Environment variables are present in the form of key-value pairs in Jenkins. These custom environment variables apply to every build on every node. We can use them in Jenkins' configuration (as $key or ${key} ) and we will add them to the environment for processes launched from the build.
 
In the next sub-section, we will see how to configure and use environment variables in Jenkins.
How to configure Environment variables in Jenkins?
In this section, let's see how to configure as well as use Environment variables in Jenkins. Kindly follow the below steps to achieve it:
Step 1: Under the configuration page, specify the name and value of the Environment variable like in the below image. After putting, click on the Save button. Kindly note that if you want to add multiple environment variables then you need to click on the Add button and fill in the same name and value information.
 
Step 2: Create a new job for the Environment variable demo.
 
Step 3: Go to the configure section of this job and go to the build section. Under the Build section, click on the "Add build step"  dropdown and select option "Execute Windows batch command".
 
Step 4: Now, put the below command in the text area section and click on the Save button. echo %ENV_DEMO%
Here ENV_DEMO  is the same variable name that we defined in the environment variable section.
 
Step 5: Now run the build by clicking the "Build Now"  link and go to console output to see the result:
 
As we can see in the above image, the value that highlights in the red rectangle is the same value that we set in the environment variable section under the configure the system. So, in this way, we can configure and use the Environment variable.
What is Usage statistics?
In any open source project, tracking usage data is very difficult. To address this need, we use the Usage statistics option. When we enable this option, Jenkins periodically sends information like Jenkins version, information about agents, OS type and executors, installed plugins and versions and number of jobs, etc. All types of usage statistics are published at https://stats.jenkins.io/.
What is the Git Plugin option?
When we try to push our code from Git then we need to configure our username as well as email for authentication purposes. Jenkins gives this option under the Git Plugin section:
•	Global Config user.name Value: if we will give username here then git command git config user. name "your username" will be called.
•	Global Config user.email Value: if we will give email here then git command git config user.email "your email" will be called.
 
Here, Credential based authentication, we generally used as we use username and email to push our code into the repository. So, we can put these values as a part of global configurations.
What is Email Notification?
Email notification option configures SMTP settings for sending mail to specified recipients. This section has two fields that we need to configure:
•	SMTP server: We need to specify the name of the SMTP mail server here. Jenkins uses JavaMail for sending out e-mails.
•	Default user e-mail suffix: If our users' e-mail addresses can compute automatically by simply adding a suffix, then specify that suffix, otherwise leave it empty.
 
Now, the question is how to configure these email notification options. So we will elaborate on this section in the further article named "Notification". Conclusively, that's all for discussion regarding some important and most widely used configurations in Jenkins. Subsequently, in the next section, let's see some important takeaway

•	Jenkins home directory - This attribute tells us the placement of our home directory of Jenkins in the system.
•	System Message - A system message displays the messages on the Jenkins dashboard page.
•	Executors - This configuration option tells us that how many parallel jobs can be run at the Jenkins machine.
•	Usage option - This option tells us that how Jenkins schedules build on any node.
•	Quiet period - When this option is non-zero, newly triggered builds of this project will be added to the queue, but Jenkins will wait for the specified period of time (in seconds ) before actually starting the build.
•	Jenkins URL - This option, by default, depicts the HTTP address of Jenkins installation in the form of localhost. We can write DNS (Domain Name ) of our machine or overwrite the localhost with the IP address of the machine.
•	Environment variable - Environment variables apply for every build on every node. They can be used in Jenkins' configuration (*as $key or ${key} *) and will be added to the environment for processes launched from the build.
•	Usage statistics - This option is used to track usage data in Jenkins.
•	Git Plugin - This option is used to set global git username and email details in Jenkins.
•	Email notification - This option is used to configure email related configurations to send email regarding build result after running builds.


''''''''''''''''''''''''''''''''''''''''''
