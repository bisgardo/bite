# Bite

Micro utility library for doing bit-fiddling in Java.

The name "bite" is a mixture of the words "bit" and "byte",
and also refers to the fact that the library itself is
"bite-sized" and involves biting bit patterns into submission.

The library is made mostly as a recreational exercise and may
or may not have any real usages.

## Functions

The Java Language Specification defines the following four
primitive integer types:

| Type    | Width             |
| ------- | ----------------- |
| `byte`  | 1 byte (8 bits)   |
| `short` | 2 bytes (16 bits) |
| `int`   | 4 bytes (32 bits) |
| `long`  | 8 bytes (64 bits) |

In bite, there's a utility class for each of these types
that contains functions for composing values into wider types,
slicing them into narrower ones, 
overwriting sections of their bit pattern,
etc.


## Indexing

All indices are zero-based and increments from right to left.

The same rule applies when a value is interpreted as a
composition of narrower ones.
E.g., an int interpreted as four bytes, the zeroth byte is
the right-most one etc.

## Status

The library has no known bugs, but is also not very well tested.

It would also make sense to implement [more common patterns](http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/).
