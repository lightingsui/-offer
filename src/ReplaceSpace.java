/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串
 * 为We%20Are%20Happy。
 *
 * @author ：LightingSui
 * @since ：2020/2/14 22:47
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        String s = replaceSpace(str);

        System.out.println(s);
    }

    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }
}
