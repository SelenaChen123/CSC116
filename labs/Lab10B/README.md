# csc116-002-Lab10B-12

# Debugging

moveSecondJokerDownTwo (WBT)

- Moved secondHalfOfDeckWithoutFirstTwoCards declaration to before the second if statement.
- Copied the return statement in the first if statement to the second if statement.
- Removed the space and secondHalfOfDeckWithoutFirstTwoCards from the return statement within the second if statement.

tripleCut (WBT)

- Added an if statement within the last if statement for when Joker A isn't the last card in the deck.
- Moved the setting of secondPartOfDeck, the declaration of middlePartOfDeck, and the return statement within the if statement that we created.
- Added a return deck statement to the end of the else statement, right before the closing brace in the else statement.

moveFirstJokerDownOne (WBT)

- Added a string for the first card in the deck within the else statement.
- Removed secondHalfOfDeck from the else statement and replaced it with a String for the middle part of the deck (middlePartOfDeck).
- Modified the return statement to return Joker A, then the middle part of the deck, and then the first card in the deck.