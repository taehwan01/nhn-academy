/*
 * 인터페이스 정의
 * 1. add
 * 2. remove(idx)
 * 3. get(idx)
 */

public interface ListGeneric {

    public <T> void add(T value);

    public void remove(int idx);

    public <T> T get(int idx);

}
