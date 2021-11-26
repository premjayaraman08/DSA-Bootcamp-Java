# String Overview

## Reference notes
[Handwritten Notes of 2 users](lectures/12-strings/String-2-users-notes.pdf)

## Q&A
- What is String ? Some hints
  - Reference variable
  - value , objects
- how to declare string
  - Is string primitive data type
  - what are the data types ?
  - Is String an object itself or list of char ?
- Internal working of string
  - Stack vs heaps
  - Are 2 strings of same value stored in different address or point to same address in heap ?  
  - String pool
- Immutability
  - Strings are immutable in java ? why ?
- Garbage collection
  - When is it done ? A: value or object does not have a reference variable
- String comparison
  - Double equals `==` value and reference variable are pointing to same object
    - eg: String a= "Prem", String b="Prem" a==b would be `true` due to storing of strings from string pool
  - String `equals` method only checks values but not reference variables
    - eg: String a = new String("Prem), String b = new String("Prem") a==b would be `false` since both have independent reference variables
    - ```a.equals(b)``` would be `true` since both have same values 
- Internal working of println
  - How `toString()` method is called
- Operator Overloading of string
  - On concatenating atleast one should have a string while concatenating
  - Integer plus string converts Integer to `toString()` wrapper method
## String Performance [VVI]
   ```
   public static void main(String[] str){
    String series ="";
    for(int i=0;i<=26;i++){
        char ch=(char)('a'+i);
        series= series+ch;
   }
   o/p abcdefghijklmnopqrstuvwuyz
   ```
- Since strings are immutable everytime a new string is appended a new object is created which affects the performance
- every time `series` variable is appended, new string object is created then copies old value before appending new value
- Once appended the previous string object created is derefferenced creating wastage of memory
- eg: a,ab,abc, abcd, ....abcdeg ... : all these have to garbage collected as they still occupy space in memory

## Solution : StringBuilder class
- Class like string but the values are mutable
- Not create new string object but rather add to original ones
   ```
   public static void main(String[] str){
    StringBuilder builder =new StringBuilder();
    for(int i=0;i<=26;i++){
        char ch=(char)('a'+i);
        builder.append(ch);
   }
   o/p abcdefghijklmnopqrstuvwuyz
   ```
- Many more helpful methods are also present like 
  - toCharArray() - convert sting to CharArray
  - getBytes()
  - toLowerCase
  - length()