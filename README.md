[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.yannrichet/JMathArray/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.yannrichet/JMathArray)
[![Build Status](https://travis-ci.org/yannrichet/jmatharray.png)](https://travis-ci.org/yannrichet/jmatharray)
[![codecov](https://codecov.io/gh/yannrichet/jmatharray/branch/master/graph/badge.svg)](https://codecov.io/gh/yannrichet/jmatharray)

# JMathArray: basic math in Java

JMathArray provides classes with static methods for basic math in Java. Random number generations is based on RngPack?, linear algebra is based on Jama.

List of static methods applicable on int and double arrays (double[][]):

* merge, insert, delete rows and columns : org.math.array.DoubleArray, org.math.array.IntegerArray
* simple linear algebra: LU, QR, EigenValues?, Cholesky, SingularValues? (based on JAMA package): org.math.array.LinearAlgebra
* simple statistics: mean, variance, covariance, histograms : org.math.array.StatisticSample
* some random generators (based on RnGPack): normal, lognormal, triangular, chi square, weibull, ... : org.math.array.StatisticSample 

## Example Java code ##
```java
import static org.math.array.LinearAlgebra.*;
...
  // random 4 x 4 matrix + Id
  double[][] A = plus(random(4, 4), identity(4));
                
  // Eigen values Decomposition : A = V * D * V^-1
  EigenvalueDecomposition eig = eigen(A);
  double[][] V = eig.getV();
  double[][] D = eig.getD();
```
JMathArray syntax is stable. Only new features may be added, and current syntax will stay available.

## Use it ##


Put https://github.com/yannrichet/jmatharray/blob/master/dist/jmatharray.jar in your java classpath

Or include maven dependency:
```xml
<dependencies>
...
    <dependency>
      <groupId>com.github.yannrichet</groupId>
      <artifactId>jmatharray</artifactId>
      <version>1.0</version>
    </dependency>
...
</dependencies>
```

Then add a static import statement in your class:
```java
import static org.math.array.DoubleArray.*;
import static org.math.array.LinearAlgebra.*;
import static org.math.array.StatisticSample.*;
```



![Analytics](https://ga-beacon.appspot.com/UA-109580-20/jmatharray)
