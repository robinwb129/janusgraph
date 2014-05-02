package com.thinkaurelius.titan.hadoop.formats.noop;

import com.thinkaurelius.titan.hadoop.HadoopVertex;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Use NoOpOutputFormat to ensure that sideeffect data is outputted, but not graph data.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class NoOpOutputFormat extends FileOutputFormat<NullWritable, HadoopVertex> {

    @Override
    public final RecordWriter<NullWritable, HadoopVertex> getRecordWriter(final TaskAttemptContext job) throws IOException, InterruptedException {
        return new NoOpRecordWriter();
    }
}