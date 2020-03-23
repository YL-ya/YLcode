package com.dataStrcture.huffmantree;
//哈夫曼编码：前缀编码：也是无损压缩
//没有有个编码是有相同的，长度为133，原先定长编码是359，用于压缩
//排序方法可能不同，也就可能哈夫曼数的编码是不同的，但是最终形成的哈夫曼编码长度是一样的
/*编码的原理：
* 1：传输的字符串
* 2：各个字符对应的次数
* 3：将次数当成权值，构建哈弗曼树
* 4：根据哈弗曼树每个媳妇进行编码：左0，右1*/
/*构建哈弗曼树的原理：
* 1：进行排序，
* 2：从ArrayList中去取前两个数
* 3：将前两个数进行加法，之后放入ArrayList中
* 4：再次济宁排序，也就循环上去了*/
/*压缩的过程：
* 1：构建一个新的节点：Node{data：存放的数据，weight：权值，left，right}
* 2：得到字符串的byte数组：i like java
* 3：编写一个方法：将构建哈夫曼数的节点放在List中，data：数据，weight：权值
* 4：通过List创建哈弗曼树*/

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//创建Node,带上数据和权值
class NodeCoding implements Comparable<NodeCoding>{
    Byte data;//因为字母在计算机底层是数字:'a'=97
    int weight;//权值：也就是字符出现的次数
    NodeCoding left;
    NodeCoding right;

    public NodeCoding(Byte data,int weight) {
        this.data=data;
        this.weight=weight;
    }

    @Override
    public int compareTo(NodeCoding o) {
        //从从小到大：
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "NodeCoding{" +
                "data=" + data +
                ", weight=" + weight + '}';
    }

    //前序遍历：
    public void preOrder(){
        System.out.println(this.weight);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}
public class HuffmanCoding {
    private static List<NodeCoding> getNode(byte[] bytes) {
        //1：创建顺序表：
        ArrayList<NodeCoding> nodes = new ArrayList<NodeCoding>();

        //2：遍历bytes数组，统计每个bytes出现的次数→map[key,value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);//说明还没有放进去过
            } else {
                counts.put(b, count + 1);
            }
        }
        //循环结束后，Map里面存放的就是每个字符对应的个数

        //3：把每一个键值对转换成一个NodeCoding对象，并加入到nodes集合中去
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {//遍历我们的Map
            nodes.add(new NodeCoding(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] contentbytes=content.getBytes();
        System.out.println(contentbytes.length);//40

        List<NodeCoding> nodes=getNode(contentbytes);
        System.out.println("nodes"+nodes);
    }
}
