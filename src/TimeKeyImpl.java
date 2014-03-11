
import Operators.ListOperator;
import Wrappers.ListWrapper;
import java.util.Objects;

public class TimeKeyImpl implements Timer.TimeKey {

    private final int size;
    private final ListOperator op;
    private final ListWrapper wrapper;

    public TimeKeyImpl(int size, ListOperator op, ListWrapper wrapper) {
        this.size = size;
        this.op = op;
        this.wrapper = wrapper;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.size;
        hash = 97 * hash + Objects.hashCode(this.op);
        hash = 97 * hash + Objects.hashCode(this.wrapper);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final TimeKeyImpl other = (TimeKeyImpl) obj;
        if (this.size != other.size)
            return false;
        if (!Objects.equals(this.op, other.op))
            return false;
        if (!Objects.equals(this.wrapper, other.wrapper))
            return false;
        return true;
    }
}
