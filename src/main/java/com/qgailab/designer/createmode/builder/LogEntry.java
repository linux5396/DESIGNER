package com.qgailab.designer.createmode.builder;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author linxu
 * @date 2020/1/19
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
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
