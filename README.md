# HKBBK-KINESIS

Source code for hkbbkKinesisApplication

# Requirement

Java SE 8

#Developer kits

Eclipse IDE for Java Developers

Version: Mars.2 Release (4.5.2)

# First Install source to Eclipse

- Either from the context menu or from the menu bar's Window menu, select show view -> other.
- Search Git Repositories.
- In Git Repositories, select Clone a Git repository.
- Url : https://github.com/morustechnology/HKBBK-KINESIS.git.
- Directory set you want.

#Build

1. Create Run Setting
  - right click project name in Eclipse, select Properties.
  - Run/Debug Settings, select New -> Java Application.
  - Enter the Name and Search Main class to hkbbkKinesisApplication.controller.KinesisApplication.
  - Apply.
  
2. Creating a New JAR File
  - Either from the context menu or from the menu bar's File menu, select Export.
  - Select Java -> Runnable JAR file
  - Launch configuration set to Create Run Setting name.
  - Library handling set to Extract required libraries into generated JAR.
  - build JAR.

