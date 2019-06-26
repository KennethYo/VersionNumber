# VersionNumber

> Copy from [gradle](https://github.com/gradle/gradle/blob/master/subprojects/core/src/main/java/org/gradle/util/VersionNumber.java).

Represents, parses, and compares version numbers. Supports a couple of different schemes:

* MAJOR.MINOR.MICRO-QUALIFIER (the default).
* MAJOR.MINOR.MICRO.PATCH-QUALIFIER.

The parse method handles missing parts and allows "." to be used instead of "-", and "_" to be used instead of "." for the patch number.

This class considers missing parts to be 0, so that "1.0" == "1.0.0" == "1.0.0_0".

Note that this class considers "1.2.3-something" less than "1.2.3". Qualifiers are compared lexicographically ("1.2.3-alpha" < "1.2.3-beta") and case-insensitive ("1.2.3-alpha" < "1.2.3.RELEASE").

To check if a version number is at least "1.2.3", disregarding a potential qualifier like "beta", use version.getBaseVersion().compareTo(VersionNumber.parse("1.2.3")) >= 0.

# Adding VersionNumber to your build

```gradle
dependencies {
  compile 'me.kennethyo.library:version-number:1.0.0'
  // or, for Android:
  implementation 'me.kennethyo.library:version-number:1.0.0'{
    exclude group: 'com.google.guava', module: 'guava'
  }
  implementation 'com.google.guava:guava:28.0-android'
}
```