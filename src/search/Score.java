/**
 * FileName: Score
 * Author:   yangqinkuan
 * Date:     2019-9-5 17:36
 * Description:
 */

package search;

public class Score {
    private String uuid;
    private short score;

    public Score() {
    }

    public Score(String uuid, short score) {
        this.uuid = uuid;
        this.score = score;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }
}
