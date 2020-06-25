第三次作业
17030130021
张维越

java实现德州扑克双方手牌比较牌值大小
由于题目所给条件有所欠缺（没有四条，没有葫芦），所以在网上找到了原规则，并作了简化，具体要求如下：
-High Card. Hands which do not fit any higher category are ranked by the value of their highest card. 
-Pair. 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
-Two Pairs. The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.
-Three of a Kind. Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.
-Straight. Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.
-Flush. Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.
-Full House. 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.
-Four of a kind. 4 cards with the same value. Ranked by the value of the 4 cards.
-Straight flush. 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.
一共九种情况，当出现牌面形式相同时，比较最高位的牌值，需要注意的是，如果是葫芦（3+2），比较的应该是三条的牌值，而非最大的。
简化的地方为：只比较一次最高牌值，比如散牌，只比较一次最高位，如果相同即为平局，不再比较次高位。

原作业TexasPoker的package下建TexasPoker类来实现。
采用读取文件的形式作为输入，
具体函数以及功能已在代码中注释，不再赘述。