Minimum Jump Word Change App
===========
 
This App takes in 3 Input and Returns the Output in the UI

 1st input - A list of 3 letter words. 

 2nd input - One word from the above list. 

 3rd input - Another word from the list. 

The output is number that signifies the smallest number of hops/jumps that one can make from the

2nd input to reach the 3rd input. Every hop/jump has the following rules :

 1. In every hop/jump you can change only one character at a time. 

 2. The resulting word should be in the list. 

Example :

1st Input = [&quot;cat&quot;,&quot;cii&quot;,&quot;sim&quot;,&quot;xim&quot;,&quot;yep&quot;,&quot;syd&quot;,&quot;pol&quot;,&quot;sit&quot;,&quot;sii&quot;,&quot;mat&quot;,&quot;sat&quot;,&quot;cit&quot;]

2nd Input = &quot;cat&quot;

3rd Input = &quot;sii&quot;

Hops/Jumps path :

&quot;cat&quot; -&gt; &quot;cit&quot; -&gt; &quot;cii&quot; -&gt; &quot;sii&quot;

Output - 4


Pre-requisites
--------------

- Android SDK v25
- Android Build Tools v25.0.3

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

Support
-------

- Google+ Community: https://plus.google.com/communities/105153134372062985968
- Stack Overflow: http://stackoverflow.com/questions/tagged/android

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request through GitHub.

License
-------

Copyright 2016 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
