#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Sep  3 12:16:03 2018

@author: rahul
"""

"""Implement a function recursivly to get the desired
Fibonacci sequence value.
Your code should have the same input/output as the 
iterative code in the instructions."""

def get_fib(position):
    if(position<0):
       return 0
    if(position==1):
        return 0
    if(position==2):
        return 1
    else:
        return get_fib(position-1)+get_fib(position-2)
    

# Test cases
print get_fib(9)
print get_fib(11)
print get_fib(0)
