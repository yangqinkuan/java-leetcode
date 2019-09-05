/**
 * FileName: TitleNode
 * Author:   yangqinkuan
 * Date:     2019-9-5 15:00
 * Description:
 */

package search;

public class TitleNode {
    private char c;
    private TitleNode last;

    public TitleNode() {
    }

    public TitleNode(char c, TitleNode last) {
        this.c = c;
        this.last = last;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public TitleNode getLast() {
        return last;
    }

    public void setLast(TitleNode last) {
        this.last = last;
    }
}
