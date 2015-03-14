| **Professional support is now available at https://sites.google.com/site/mulabsltd/products/jmatharray**|
|:|

# JMathArray: basic math engineering in Java #
JMathArray provides classes with static methods for basic math engineering in Java. Random number generations is based on RngPack, linear algebra is based on Jama.

List of static methods applicable on int and double arrays (`double[][]`):
  * merge, insert, delete rows and columns : [org.math.array.DoubleArray](http://jmatharray.googlecode.com/svn/trunk/jmatharray/doc/org/math/array/DoubleArray.html), [org.math.array.IntegerArray](http://jmatharray.googlecode.com/svn/trunk/jmatharray/doc/org/math/array/IntegerArray.html)
  * simple linear algebra: LU, QR, EigenValues, Cholesky, SingularValues (based on JAMA package): [org.math.array.LinearAlgebra](http://jmatharray.googlecode.com/svn/trunk/jmatharray/doc/org/math/array/LinearAlgebra.html)
  * simple statistics: mean, variance, covariance, histograms : [org.math.array.StatisticSample](http://jmatharray.googlecode.com/svn/trunk/jmatharray/doc/org/math/array/StatisticSample.html)
  * some random generators (based on RnGPack): normal, lognormal, triangular, chi square, weibull, ... : [org.math.array.StatisticSample](http://jmatharray.googlecode.com/svn/trunk/jmatharray/doc/org/math/array/StatisticSample.html)

# Example Java code #
```
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

# Use it #
  1. put [jmatharray.jar](http://jmatharray.googlecode.com/svn/trunk/jmatharray/dist/jmatharray.jar) in your java classpath
  1. add a static import statement in your class:
    * `import static org.math.array.DoubleArray.*;`
    * `import static org.math.array.LinearAlgebra.*;`
    * `import static org.math.array.StatisticSample.*;`