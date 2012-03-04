Java mocks for SmartGWT's native methods.
-----------------------------------------

To enable testing Java classes which use SmartGWT's classes,
and their native methods, we want to replace these methods
with pure Java implementations, so they can be used in
JUnit tests.

Of course, we won't provide Java implementations of the
widgets (these are better tested in integration tests,
using Selenium or similar tools), only the pure data parts
which are easily mockable.


This work is based on SmartGWT, LGPL edition, and thus available
under terms of the GNU Lesser Public General License, version 3.

It also partly relies on Google Web Toolkit, which is available
under the Apache License v. 2.0.
