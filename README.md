# SDA-Tute
- Clone this repo `git clone https://github.com/victorskl/sda-tute.git`
- Download and install [Eclipse IDE for Java EE Developers](https://www.eclipse.org/downloads/eclipse-packages/)
- Launch the Eclipse and, when an open dialog for workspace, point to this `sda-tute` folder.
- Import workspace preference: File > Import > General > Preferences > [Browse to `sda-tute` folder] > `sda-tute.epf`
- Import team project set: File > Import > Team > Team Project Set > [Browse to `sda-tute` folder] > `sda-tute.psf`

### Eclipse JDK and Server Library
- Next to fix any unbound JDK and Server Library: Right Click on the project (e.g `SimpleServletProject`) > Build Path > Configure Build Path... > Libraries tab > remove any unbound library. 

![buildpath_unbound.png](https://www.dropbox.com/s/q4ut54oirskphdc/buildpath_unbound.png?raw=1)

- Then Add Library > JRE System Library > Alternate JRE > Installed JREs to set an approprieate JDK as default and add to project.
- Configure Apache Tomcat with Eclipse as follows: File > New > Other... > Server > Server > Next > Apache > Tomcat 8.5 > at Tomcat installation directory > Browse and point to where you downloaded and extracted the `apache-tomcat-8.5.16-windows-x64.zip`

### Enable Eclipse Working Sets

![workingset1.png](https://www.dropbox.com/s/5a4raijk0t03bbu/workingset1.png?raw=1)

![workingset2.png](https://www.dropbox.com/s/7y7uq6wpt88sx3u/workingset2.png?raw=1)

![workingset3.png](https://www.dropbox.com/s/412yvcgk371bjf2/workingset3.png?raw=1)

![workingset4.png](https://www.dropbox.com/s/krat111xzltg76l/workingset4.png?raw=1)
