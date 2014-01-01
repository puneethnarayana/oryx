/*
 * Copyright (c) 2013, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */

package com.cloudera.oryx.als.computation.merge;

import com.cloudera.oryx.als.common.NumericIDValue;
import com.cloudera.oryx.computation.common.fn.OryxMapFn;
import org.apache.crunch.Pair;

public final class TransposeUserItemFn extends OryxMapFn<Pair<Long, NumericIDValue>, Pair<Long, NumericIDValue>> {
  @Override
  public Pair<Long, NumericIDValue> map(Pair<Long, NumericIDValue> input) {
    return Pair.of(input.second().getID(), new NumericIDValue(input.first(), input.second().getValue()));
  }
}