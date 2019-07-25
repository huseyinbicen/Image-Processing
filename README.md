# Image-Processing
It's code of about image processing in my University education

OCL stands for Open Cezeri Library (yet another matrix library). This library provides rapid coding as matlab ease of use. 
If you want to know how can you use library please try to use test examples at OpenCezeriLibrary\test\test. 
It is originally developed at el-cezeri laboratory in Siirt University, in order to establish 
generic framework of reusable components and software tools for machine vision, machine learning, AI and robotic applications. 
Currently, it holds following main concepts
1- Vision:  
  It can access web cams, imaging source industrial cameras for manual settings and advanced issues. Studies on accessing Leapmotion and Kinect is still under-development.
2- Machine learning:
  It uses Weka Software tool and some personel coded ML algorithms
3- CMatrix:
  Special matrix library called as CMatrix meaning Cezeri Matrix Class. It is regarded as the core of the OCL.  CMatrix class was implemented as singleton design pattern so you need to call getInstance methods to instantiate the matrix object. Almost all methods return CMatrix obejct which enables programmer to write a program in a single line of code by putting "." in between the methods. In the CMatrix class, there exists various well known  matlab functions like plot, imshow, cat, rand, linspace and so on. Moreover commandParser method imitates Matlab vectorization skill such as (:,1:end) and so on. CMatrix is located at the core/center of the OCL and somehow relates to other classes i.e. ImageProcess, FactoryUtils etc. Novice user or programmer needs to understand only CMatrix and from there  they can reach any other functions of other classes.Hence it can be considered as a kind of broker class or main class. Neverthless, experienced developer can utilize the FactoryUtils, ImageProcessing and other classes directly for gaining extra performance power.

Notification: If you think OCL is useful for you, please cite OCL paper below in your studies and papers. 

Library Link: https://github.com/hakmesyo/open-cezeri-library
