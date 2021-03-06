# SDA-Tute

Software Design and Architecture Tutorials

*I still (highly) recommend, you attempt first following the tute note.*

*Response to discussion questions are my own attempts and observation. I can not endorse 100% correctness of these responses in the context of how the subject is framing. Please approach the respective lecturer, tutor or use your own discretion.*

### By Workshop

Eclipse Projects are logically group by Working Sets (see below). However, for convenience, here are group by view.

Workshop 1
- [SimpleWebProject](SimpleWebProject)
- [SimpleServletProject](SimpleServletProject)

Workshop 2
- [LoginAppMVCProject](LoginAppMVCProject)

Workshop 3
- none

Workshop 4
- [SpringDemo](SpringDemo)
- [SpringMVCDemo](SpringMVCDemo)

Workshop 5
- [HibernateExamples](HibernateExamples)

Workshop 6
- [HibernatePatternsForDataSourceLayer](HibernatePatternsForDataSourceLayer)
- [SpringHibernate](SpringHibernate)

Workshop 7
- [Security](Security)
- [SecurityDbAuth](SecurityDbAuth)

Workshop 8
- none

Workshop 9
- [JMSPointToPoint](JMSPointToPoint)
- [JMSPublishSubscribe](JMSPublishSubscribe)


### Quick demo

- http://cloud.sankholin.com/SimpleWebProject/
- http://cloud.sankholin.com/SimpleServletProject/
- http://cloud.sankholin.com/LoginAppMVCProject/
- http://cloud.sankholin.com/SpringMVCDemo/

### How to 

- Clone this repo `git clone https://github.com/victorskl/sda-tute.git`. Or update it if you have already clone before. Fetch and pull to the latest by:
    ```
    cd sda-tute
    git fetch
    git pull
    ```

- Download and install [Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/eclipse-packages/)

- Launch the Eclipse and, when an open dialog for workspace, point to this `sda-tute` folder.

- Import workspace preference: File > Import > General > Preferences > [Browse to `sda-tute` folder] > `sda-tute.epf`

- Import team project set: File > Import > Team > Team Project Set > [Browse to `sda-tute` folder] > `sda-tute.psf`

### Eclipse JDK and Server Library

- Next to fix any unbound JDK and Server Library: Right Click on the project (e.g `SimpleServletProject`) > Build Path > Configure Build Path... > Libraries tab > remove any unbound library. 

![buildpath_unbound.png](https://www.dropbox.com/s/q4ut54oirskphdc/buildpath_unbound.png?raw=1)

- Then Add Library > JRE System Library > Alternate JRE > Installed JREs to set an approprieate JDK as default and add to project.

- Configure Apache Tomcat with Eclipse as follows: File > New > Other... > Server > Server > Next > Apache > Tomcat 8.5 > at Tomcat installation directory > Browse and point to where you downloaded and extracted the `apache-tomcat-8.5.16-windows-x64.zip`

- Next you may also need to add [Eclipse Dynamic Web Module project facet](https://www.mkyong.com/java/how-to-convert-java-project-to-web-project-in-eclipse/) by Right Click on the project (e.g `SimpleServletProject`) > Properties > Project Facets > check (Dynamic Web Module, Java, JavaScript) 

![convert_to_dynamic_web.png](https://www.dropbox.com/s/lnvyhcexrl82x8c/convert_to_dynamic_web.png?raw=1)

### Enable Eclipse Working Sets

![workingset1.png](https://www.dropbox.com/s/5a4raijk0t03bbu/workingset1.png?raw=1)

![workingset2.png](https://www.dropbox.com/s/7y7uq6wpt88sx3u/workingset2.png?raw=1)

![workingset3.png](https://www.dropbox.com/s/412yvcgk371bjf2/workingset3.png?raw=1)

![workingset4.png](https://www.dropbox.com/s/krat111xzltg76l/workingset4.png?raw=1)


### Code Style (Optional)

- Setup code style. This is optional.

- Preferences > Java > Code Style > Formatter > Import > browse to sda-tue folder > code-style-profile.xml
![code-style-import.png](https://www.dropbox.com/s/vdkd2wnz12stc85/code-style-import.png?raw=1)

- Preferences > General > Text Editors > insert spaces for tabs
![insert-spaces-for-tab.png](https://www.dropbox.com/s/giacmu7uvkyt2iz/insert-spaces-for-tab.png?raw=1)
