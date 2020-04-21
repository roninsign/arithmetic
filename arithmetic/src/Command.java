import com.util.CreatFile;
import com.util.IsRight;
import com.util.MyExpection;

public class Command {

    public static void main(String[] args) throws  Exception {
        MyExpection  myExpection= new MyExpection();
        try {
            if (args.length < 5) {
                throw  new Exception(myExpection.MyExpection1());
            } else {
                IsRight isRight = new IsRight();
                int n = isRight.numberTest(args);//题目的数量
                int m[] = isRight.mTest(args);//数值范围
                int o = isRight.symbolTest(args);//运算符的数量
                int c = isRight.cTest(args);//如果包含乘除，c=1;如果不包含 c=2；
                int b = isRight.isBracket(args);//是否有括号，b=1,you;b=2，不包含。
                if (n == 0 || m[0] == 0 || m[1] == 0) {
                    throw  new Exception(myExpection.MyExpection1());
                }
                CreatFile creatFile = new CreatFile();
                creatFile.creatFile(n,m[0],m[1],o,c, b );
            }
        } catch (Exception e) {
            throw new Exception(myExpection.MyExpection1());
        }
    }
}
