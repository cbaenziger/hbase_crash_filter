/** * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bloomberg.hbase;

import java.util.List;
import java.util.Random;
import java.util.Stack;
import com.google.protobuf.InvalidProtocolBufferException;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.exceptions.DeserializationException;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterBase;
import org.apache.hadoop.hbase.filter.Filter.ReturnCode;

import com.bloomberg.hbase.generated.FilterProto;

public class CrashFilter extends FilterBase {

  public CrashFilter() {
    super();
  }

  public CrashFilter(byte[] value) {
  }

  @Override
  public void reset() {
  }

  @Override
  public Filter.ReturnCode filterKeyValue(Cell cell) {
    Random random = new Random();
    Stack<Double> leaky = new Stack<Double>();
    while (true) {
      leaky.add(random.nextDouble());
    }
    //return Filter.ReturnCode.INCLUDE;
  }

  @Override
  public boolean filterRow() {
    Random random = new Random();
    Stack<Double> leaky = new Stack<Double>();
    while (true) {
      leaky.add(random.nextDouble());
    }
    //return false;
  }

  @Override
  public void filterRowCells(List<Cell> kvs) {
    Random random = new Random();
    Stack<Double> leaky = new Stack<Double>();
    while (true) {
      leaky.add(random.nextDouble());
    }
    //return;
  }

  @Override
  public boolean filterRowKey(byte[] buffer, int offset, int length) {
    Random random = new Random();
    Stack<Double> leaky = new Stack<Double>();
    while (true) {
      leaky.add(random.nextDouble());
    }
    //return false;
  }

  @Override
  public Cell getNextCellHint(Cell currentKV) {
    Random random = new Random();
    Stack<Double> leaky = new Stack<Double>();
    while (true) {
      leaky.add(random.nextDouble());
    }
    //return currentKV;
  }

  @Override
  public boolean hasFilterRow() {
    Random random = new Random();
    Stack<Double> leaky = new Stack<Double>();
    while (true) {
      leaky.add(random.nextDouble());
    }
    //return false;
  }

  @Override
  public boolean isFamilyEssential(byte[] name) {
    Random random = new Random();
    Stack<Double> leaky = new Stack<Double>();
    while (true) {
      leaky.add(random.nextDouble());
    }
    //return false;
  }

  @Override
  public Cell transformCell(Cell v) {
    Random random = new Random();
    Stack<Double> leaky = new Stack<Double>();
    while (true) {
      leaky.add(random.nextDouble());
    }
    //return v;
  }

  // Thanks to Lars George - https://github.com/larsgeorge/hbase-book/blob/cbb4bd05e30fb7956e43d7327ca7086c0578e8e2/ch04/src/main/java/filters/CustomFilter.java#L60-L69
  public static Filter parseFrom(final byte[] pbBytes)
  throws DeserializationException {
    FilterProto.CrashFilterProto proto;
    try {
      proto = FilterProto.CrashFilterProto.parseFrom(pbBytes);
    } catch (InvalidProtocolBufferException e) {
      throw new DeserializationException(e);
    }
    return new CrashFilter();
  }

  @Override
  public byte [] toByteArray() {
    FilterProto.CrashFilterProto.Builder builder =
      FilterProto.CrashFilterProto.newBuilder();
    return builder.build().toByteArray();
  }
}
