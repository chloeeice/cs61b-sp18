import java.util.NoSuchElementException;

//直接看的答案
public class SLListVista extends SLList {
    @Override
    public int indexOf(int x) {
        int index = super.indexOf(x);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return index;
    }
}
