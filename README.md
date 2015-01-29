TaiTree
=======

Tai-Tree is a framework for Artificial Intelligence (AI) system that allow users to quickly design decision trees and train the AI to make inferences.

Whats it for?
=======
TaiTree is a framework for developers that allow them to build smart decision trees that allows their applications to make step-by-step choices.   

How it works
=======
Train your AI using one of wizards provided. It will generate a JSON file. Execute the JSON file and it will synchronously take a user through a decision tree so that he may come to a decision on his problem. The developer could also get the JSON file as an object.

Example Output
=======
SandwichAI.java example:


```
Do you have peanut butter, jelly and bread?
1. NO
2. YES
Input:
1
Go get the required items and start over
```

```
Do you have peanut butter, jelly and bread?
1. NO
2. YES
Input:
2
Do you have a butterknife?
1. NO
2. YES
Input:
1
Do you have spoon?
1. NO
2. YES
Input:
2
Do you have a plate?
1. YES
2. NO
Input:
2

Grab a napkin and butter your bread on the napkin with the end of your spoon.

```


=======
Add "TaiTree.jar" to properties build libraries (not enabled)

Cocoapods Use
=======
cocoapods taitree (not enabled)

Node JS
=======
npm install taitree (not enabled)

