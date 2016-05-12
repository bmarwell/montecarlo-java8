# montecarlo-java8
Some examples on how to use java8 features (like streams) to solve easy excercies.

## pi
"Calculate" (guess) the number pi by random dots. Count, if they are inside a circle.
<https://en.wikipedia.org/wiki/Pi#Monte_Carlo_methods>

## The Dice Rolling Drinking Game
Reddit: <https://www.reddit.com/r/math/comments/408a45/how_many_turns_does_it_take_on_average_until_this/>.
Mathematical solution: <http://mindyourdecisions.com/blog/2016/03/06/how-long-will-this-drinking-game-last-sunday-puzzle/>.

### Description
The game starts with 6 empty glasses in a row numbered 1 to 6. You roll a standard die. If the number for the glass is empty, then the glass is filled up. If the number for the glass is full, then you drink that glass. There is a special rule when 5 glasses are full. If you roll the number for the lone empty glass, then the final glass gets filled and you have to drink all 6 glasses. At this point the game ends.

From the start of the game, what is the average number of rolls until the game ends?

### Dice Rolling Drinking Game on Youtube
[![Dice Rolling Drinking Game on Youtube](http://img.youtube.com/vi/Mdqt5EknXBg/0.jpg)](http://www.youtube.com/watch?v=Mdqt5EknXBg)