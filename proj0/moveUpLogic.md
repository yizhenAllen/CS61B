```java
|8
|
|2
|4
```

## 处理一列中press up的逻辑
- `public boolean oneColMoveUp(int col)`

- 加粗的是指要写的helper method

从`row = size-2`开始判断, 对非null的一个tile, 找**上面第一个不是null的方块**, 返回方块的索引
如果上面全都是null, 返回board.size(), 后续必定移动, 可以使用**移动到它的下面一个**

如果返回对应的row, 后续不一定移动, 此情况下的移动写一个method: **移动到它的下面一个**

我需要知道对应的这个方块是不是已经合并过的, 所以需要merged标签
`merge = false`; 这个标签和初始值应该在循环开始前就创建好

如果对应方块的`row==size`, 那就**移动到它的下面一个**
然后开始判断合并过吗:
  如果合并过, 就**移动到它的下面一个**, 并令`merged = false`
  如果没有合并过, 我再判断数值是否一样:
    如果数值一样, 合并, `merged = true`
    如果不一样, 就**移动到它的下面一个**, `merged = false`

如果移动了, 返回`true`
