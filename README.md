# 设计模式

[TOC]

# 创建型设计模式

## 单例模式

1 定义

- 指一个类只有一个实例，且该类能自行创建这个实例的一种模式。例如，Windows 中只能打开一个任务管理器，这样可以避免因打开多个任务管理器窗口而造成内存资源的浪费，或出现各个窗口显示内容的不一致等错误。

2 特点

- 单例类只有一个实例对象
- 该单例对象必须由单例类自行创建
- 单例类对外提供一个访问该单例的全局访问点

3 实现（构造器记得私有化）

- 懒汉方法锁

```java
public static obj synchronized getInstance(){
}
```

- 懒汉volatile加双重锁

```java
//volatile禁止指令重排序
private static volatile ins;
public static obj  getInstance(){
	if(ins==null){
       synchronized(this){
          if(ins==null){
            ins=new ...
          }
       }
	}
	return ins;
}
```

- 饿汉静态块

```java
private static ins;
static{
  ins=new ...
}
```

- 懒汉内部静态类

```java
    /**
     * lazy singleton instance init.
     */
    public static obj getInstance() {
        return DefaultLazyHolder.INSTANCE;
    }
    private static class DefaultLazyHolder {
        private static final  obj INSTANCE = new  obj();
    }
```

4 应用场景与作用

- 场景
  - 数据库连接池、线程池等
- 作用
  - 节省内存资源，同时保证数据的一致性

-------------

## 原型模式

1 定义

- 原型模式就是用原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象。

在应用程序中，有些对象比较复杂，其创建过程过于复杂，而且我们又需要频繁的利用该对象，如果这个时候我们按照常规思维new该对象，那么务必会造成资源浪费，这个时候我们就希望可以利用一个已有的对象来不断对他进行复制就好了，这就是编程中的“克隆”。原型模式直接操作底层二进制流，在创建复杂对象是效率提升明显。

- 原型模式分类
  - 深克隆
    - 创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
  - 浅克隆
    - 创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。

![prototype](./img/prototype.jpg)

2 特点

- 根据已有的原型实例去创建实例，适用于创建实例过程消耗较大的情况。

3 实现

- 浅拷贝

```java
/**
 * @author linxu
 * @date 2020/1/19
 * <tip>take care of yourself.everything is no in vain.</tip>
 * clone方法是在Object种定义的,而且是protected型的,只有实现了这个接口，
 * 才可以在该类的实例上调用clone方法,否则会抛出CloneNotSupportException。
 * Object中默认的实现是一个浅拷贝,也就是表面拷贝,如果需要实现深层次拷贝的话,必须对类中可变域生成新的实例。
 */
public class ShallowCloneObj implements Cloneable {
    private Ref strRef;

    public ShallowCloneObj(Ref strRef) {
        this.strRef = strRef;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws Exception {
        Ref ref=new Ref("i am ref.");
        ShallowCloneObj originObj = new ShallowCloneObj(ref);
        ShallowCloneObj cloneObj = (ShallowCloneObj) originObj.clone();
        System.out.println(originObj.strRef.getRefStr() + "----");
        System.out.println(cloneObj.strRef.getRefStr() + "++++");
        //change ref
        ref.setRefStr("new ref str.");
        System.out.println("==================================================");
        System.out.println(originObj.strRef.getRefStr() + "----");
        System.out.println(cloneObj.strRef.getRefStr() + "++++");
    }
   static class Ref{
        String refStr;

        public String getRefStr() {
            return refStr;
        }

        public void setRefStr(String refStr) {
            this.refStr = refStr;
        }

       public Ref(String refStr) {
           this.refStr = refStr;
       }
   }
}
```

- 深拷贝（两种方式）

```java
public class DeepCloneObj implements Cloneable {
    private DeepCloneObj.Ref strRef;

    public DeepCloneObj(DeepCloneObj.Ref strRef) {
        this.strRef = strRef;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        //impl deep clone
        DeepCloneObj deepCloneObj = (DeepCloneObj) object;
        deepCloneObj.strRef = (Ref) this.strRef.clone();
        return deepCloneObj;
    }

    public static void main(String[] args) throws Exception {
        DeepCloneObj.Ref ref = new DeepCloneObj.Ref("i am ref.");
        DeepCloneObj originObj = new DeepCloneObj(ref);
        DeepCloneObj cloneObj = (DeepCloneObj) originObj.clone();
        System.out.println(originObj.strRef.getRefStr() + "----");
        System.out.println(cloneObj.strRef.getRefStr() + "++++");
        //change ref
        ref.setRefStr("new ref str.");
        System.out.println("==================================================");
        System.out.println(originObj.strRef.getRefStr() + "----");
        System.out.println(cloneObj.strRef.getRefStr() + "++++");
    }

    /**
     * 引用属性也实现cloneable
     */
    static class Ref implements Cloneable {
        String refStr;

        public String getRefStr() {
            return refStr;
        }

        public void setRefStr(String refStr) {
            this.refStr = refStr;
        }

        public Ref(String refStr) {
            this.refStr = refStr;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
```

```java
public class DeepSerializableCloneObj implements Serializable {
    private Ref strRef;

    public DeepSerializableCloneObj(Ref strRef) {
        this.strRef = strRef;
    }

    @Override
    public String toString() {
        return "DeepSerializableCloneObj{" +
                "strRef=" + strRef +
                '}';
    }

    static class Ref implements Serializable {
        String refStr;

        public String getRefStr() {
            return refStr;
        }

        public void setRefStr(String refStr) {
            this.refStr = refStr;
        }

        public Ref(String refStr) {
            this.refStr = refStr;
        }

        @Override
        public String toString() {
            return "Ref{" +
                    "refStr='" + refStr + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception{
        Ref ref=new Ref("序列化克隆");
        DeepSerializableCloneObj origin=new DeepSerializableCloneObj(ref);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(origin);
        byte[] objbytes=byteArrayOutputStream.toByteArray();

        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(objbytes);
        ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);

        DeepSerializableCloneObj cloneObj=(DeepSerializableCloneObj) objectInputStream.readObject();
        System.out.println(origin+"--");
        System.out.println(cloneObj+"++");
        //change ref
        ref.setRefStr("change");
        System.out.println(origin+"--");
        System.out.println(cloneObj+"++");

    }
}
```

4 应用场景与作用缺点

- 应用场景
  - 创建新对象成本较大（如初始化需要占用较长的时间，占用太多的CPU资源或网络资源），新的对象可以通过原型模式对已有对象进行复制来获得，如果是相似对象，则可以对其成员变量稍作修改。
  - 如果系统要保存对象的状态，而对象的状态变化很小，或者对象本身占用内存较少时，可以使用原型模式配合备忘录模式来实现。
- 作用
  - 减少创建一个类似对象的消耗。
- 缺点
  - 需要为每一个类配备一个克隆方法，而且该克隆方法位于一个类的内部，当对已有的类进行改造时，需要修改源代码，违背了“开闭原则”。
  - 在实现深克隆时需要编写较为复杂的代码，而且当对象之间存在多重的嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来可能会比较麻烦。

---------------

## Builder模式

1 定义

- builder模式也称为建造者模式，它就是将复杂事物创建的过程抽象出来，该抽象的不同实现方式不同，创建出的对象也不同。一个实例的属性有多种组合，可以由构造者自行组合构建。

2 特点

- 将实例的组装创建与负责组装创建的责任分离，同时实现自由组合。
- 避免了多种属性组合的构造器（传值构造有时候参数太多并不方便）。

3 实现

- 经典Builder模式（这里就写出具体的代码了）
  - 定义XXbuilder接口，实现多种builder实现，利用多种builder实现配合director（监工）去创建实例。
- Builder进阶也成为Builder变种
  - 下面的Builder变种在个人的distributedGateWay和RaftK-V项目中用到，使用起来非常灵活。

```java
public class LogEntry implements Serializable,Comparable {
    /**
     * 日志索引
     */
    private Long index;
    /**
     * 日志任期号码
     */
    private long term;

    public LogEntry() {
    }

    public LogEntry(long term ) {
        this.term = term;
    }

    public LogEntry(Long index, long term) {
        this.index = index;
        this.term = term;
    }

    private LogEntry(Builder builder) {
        index=builder.index;
        term=builder.term;
    }

    public static Builder Builder() {
        return new Builder();
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        if (this.index > ((LogEntry) o).index) {
            return 1;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LogEntry logEntry = (LogEntry) o;
        return term == logEntry.term &&
                Objects.equals(index, logEntry.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, term);
    }

    public static final class Builder {
        private Long index;
        private long term;
        private Builder() {
        }
        public Builder index(Long val) {
            index = val;
            return this;
        }
        public Builder term(long val) {
            term = val;
            return this;
        }
        
        public LogEntry build() {
            return new LogEntry(this);
        }
    }
}
```

4 应用场景与作用

- 解决重叠构造器阅读不方便且拓展不灵活的问题
  - 能够自由组合构造参数。
- 建造分离
  - 有时候我们希望这个类的属性构造过程对于该类是不可见的，而是由另外的类即建造者来封装处理，这个时候就使用建造者模式了。



当然，有好处肯定也有坏处，使用Builder毫无疑问，会消耗多一些内存，但是如果能够给代码提供更好的阅读和可维护、可拓展性，也是值得的。

----------------------

## 工厂模式

### 简单工厂（并不算GoF23中设计模式之中，它只是实现了解耦）

1 定义

- 简单工厂也称为静态工厂，实例化对象的时候不再使用 new Object()形式，可以根据用户的选择条件来实例化相关的类。对于客户端来说，去除了具体的类的依赖。只需要给出具体实例的标签给工厂，工厂就会自动返回具体的实例对象。

2 特点

- 将实例创建过程从实例的类中剥离，从而实现解耦。
- 可对类的实例创建拓展一些额外的工作，而不去违反实例类的开闭原则。
- 如需要创建其它实例，需要对工厂进行继承拓展；如果不拓展工厂，而直接修改工厂代码，违反了工厂的开闭原则。

3 实现

```java
public interface Strategy
```

```java
NormalStrategy implements Strategy{
  @Override
    public double discount() {
        return discount;
    }
}
SuperStrategy implements Strategy {
@Override
    public double discount() {
        return discount;
    }
}
public class StaticFactory {
    /**
     * @param level VIP level
     * @return 根据用户的LEVEL生成不同折扣策略
     */
    public static Strategy getStrategy(int level) {
        if (level == Level.NORMAL.val) {
            return new NormalStrategy(0.8);
        } else if (level == Level.SUPER.val) {
            return new SuperStrategy(0.6);
        } else {
            return null;
        }
    }

    enum Level {
        NORMAL(1), SUPER(2);
        int val;

        Level(int val) {
            this.val = val;
        }
    }
}
```

4 应用场景

- 场景，用于解耦，将生成实例与实例类剥离，由特定的工厂生成多态实例，可拓展额外的内容。
- 缺点
  - 如果增加子类或者实现类，则要修改工厂代码，使得工厂的责任臃肿，他需要利用一大堆的判断条件来决定生产具体哪一种实例。

--------------------

### 工厂方法

1 定义

- 使用继承，把对象的创建委托给子类，由子类来实现创建方法（即特定的工厂通过实现工厂接口来创建特定的对象），可以看作是抽象工厂模式中只有单一产品的情况。

2 特点

- 解耦
- 不会破坏开闭原则，理论上增加子类，就新开一家对应的工厂。就像下面举例的，茶工厂。
- 可拓展和维护性更好

3 实现

- 定义茶

```java
public abstract class Tea {
    protected String teaType;

    public abstract String showType();
}

```

- 定义茶工厂

```java
public interface TeaFactory {
    Tea createTea();
}
```

- 具体实现

```java
public class PuerTea extends Tea {
    public PuerTea(String type) {
        this.teaType = type;
    }

    @Override
    public String showType() {
        return null;
    }
}
public class PuerFactory implements TeaFactory {
    @Override
    public Tea createTea() {
        return new PuerTea("puer");
    }
}
```

4 应用场景与作用

- 工厂方法针对的是某一类对象，即茶工厂针对的都是各种茶对象，由对应的茶的工厂去创建实例。更加灵活且拓展性更好。
- 缺点
  - 假如系统需要生产除了茶还有酒，那么，就需要创建更多的类，比如酒厂接口，各种酒，酒的抽象等等。这个时候，代码就会显得臃肿，所以有人提出，**抽象工厂**（即该工厂能够创建酒、茶等各种东西），而抽象工厂的实现也具有相应的职能。

### 抽象工厂

1 定义

- 工厂是抽象的，它能够定义生产多种类产品的规范。抽象工厂的实现也有多种生产能力。

2 特点

- 化零为整，把各式各样的工厂，合并成一个多功能的工厂。
- 在实现解耦的基础上，更加容易管理。

3 实现

```java
public interface AbstractFactory {
    Tea createTea();

    Beard createBeard();
}
public abstract class Beard {
    protected String beardName;
}
public class Hanbeger extends Beard {
    public Hanbeger(String name) {
        this.beardName = name;
    }
}
public class ShenZhenFactory implements AbstractFactory {
    @Override
    public Tea createTea() {
        return new WuLongTea("wulong");
    }

    @Override
    public Beard createBeard() {
        return new Hanbeger("汉堡");
    }

    /**
     * 将工厂模式与单例模式配合使用
     */
    public static ShenZhenFactory getInstance() {
        return LazyHolder.INST;
    }

    public static final class LazyHolder {
        public static final ShenZhenFactory INST = new ShenZhenFactory();
    }
}
```

4 应用场景与作用

- 用于解耦，并且实现了更加规范化的管理，对创建实例过程进行封装。
- 化零为整
- 工厂是抽象的，它能够定义生产多种类产品的规范。抽象工厂的实现也有多种生产能力。

注意：正常来讲，一个具体的工厂应当是一个单例，配合单例模式使用能够更加节省资源，这也侧面证明了，设计模式不是互相独立的，是相辅相成的。

----------------

