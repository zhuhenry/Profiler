Author: Fernando Almeida (fernando.m.al.91@gmail.com - Personal e-mail, previous one was fernando.almeida@inatel.br), Henry Zhu (henry.zhu@zcomsystems.com)

## Problem

The Velocity Studio can generate a performance log (using jconsole), but, with the Script Call Stack, there is a lot of lines of information, but to analyze the time consumed by some call, we should check also the time consumed by it's childs. It is a mechanical effort that can, and should, be made by a computer.

## Goal

The Performance Log Analyzer check all the script call stack, calculate the consumed time by each method and display in a rank of most consuming time method to least consuming time method. In a few seconds we can see the most consuming time methods and look for bottlenecks.

## Structure of the project

It was an effort to keep the project very simple, with a few files. Currently there are 7 files:
- angular.min.js - AngularJS lib, used to display the files in a easy way, It could be used VannilaJS, but I wanted to use AngularJS just to pratice :D.
- index.html - The main file of the Performance Log Analyzer. It have the HTML that displays the table and the logic that read the script call stack, calculate the consuming time of each method call and provide the information to the HTML.
- about.html
- bottleneck.html
- Readme.md - This file :D.

Ok, files explained, let's see how we could use this Performance Log Analyzer. I'll describe how to use it in steps:

- 1 - Open the index.html;
- 2 - Upload any performance log (i.e. envX_Y.txt, after_updateProductOfferOrderItem_20.log) file one at a time
- 3 - Check the most consuming time bottlenecks and try to resolve them! (Good luck! :D).
- 4 - Click the + sign in the Call Stack column will expand its parents.

If you see "[]" in the parents column, it means that this callstack has no parent.

The Call Stack column expands to:
root
.root's child
..root's child's child
...currentCallStack