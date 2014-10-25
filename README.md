Microsoft-SnapAttack-trie
=========================

A back-end for Microsoft's Snap Attack app for Windows 8 and mobile devices. Snap Attack is best described as "Speed
Scrabble" - players race to find as many words as possible. I've made a possible back-end for this app in Java. It
loads the dictionary of words into a tree of characters (a 'trie'), which allows users to check if particular words
are in the English language very quickly (in O(n) runtime for each word that is checked). The checking algorithm
loops through each letter in the word, and traverses deeper and deeper in the trie until the end letter is reached, 
in which a boolean value will determine if the traversed path makes up a word.
