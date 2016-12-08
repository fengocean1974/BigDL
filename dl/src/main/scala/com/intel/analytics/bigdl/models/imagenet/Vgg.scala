/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intel.analytics.bigdl.models.imagenet

import com.intel.analytics.bigdl.nn._
import com.intel.analytics.bigdl._
import com.intel.analytics.bigdl.tensor.Tensor
import com.intel.analytics.bigdl.tensor.TensorNumericMath.TensorNumeric

import scala.reflect.ClassTag

object Vgg_16 {
  def apply[T: ClassTag](classNum: Int)
    (implicit ev: TensorNumeric[T]): Module[T] = {
    val model = Sequential()
    model.add(SpatialConvolution(3, 64, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(64, 64, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(SpatialConvolution(64, 128, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(128, 128, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(SpatialConvolution(128, 256, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(256, 256, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(256, 256, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(SpatialConvolution(256, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(View(512 * 7 * 7))
    model.add(Linear(512 * 7 * 7, 4096))
    model.add(Threshold(0, 1e-6))
    model.add(Dropout(0.5))
    model.add(Linear(4096, 4096))
    model.add(Threshold(0, 1e-6))
    model.add(Dropout(0.5))
    model.add(Linear(4096, classNum))
    model.add(LogSoftMax())

    model
  }
}

object Vgg_19 {
  def apply[T: ClassTag](classNum: Int)
    (implicit ev: TensorNumeric[T]): Module[T] = {
    val model = Sequential()
    model.add(SpatialConvolution(3, 64, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(64, 64, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(SpatialConvolution(64, 128, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(128, 128, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(SpatialConvolution(128, 256, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(256, 256, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(256, 256, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(256, 256, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(SpatialConvolution(256, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialConvolution(512, 512, 3, 3, 1, 1, 1, 1))
    model.add(ReLU(true))
    model.add(SpatialMaxPooling(2, 2, 2, 2))

    model.add(View(512 * 7 * 7))
    model.add(Linear(512 * 7 * 7, 4096))
    model.add(Threshold(0, 1e-6))
    model.add(Dropout(0.5))
    model.add(Linear(4096, 4096))
    model.add(Threshold(0, 1e-6))
    model.add(Dropout(0.5))
    model.add(Linear(4096, classNum))
    model.add(LogSoftMax())

    model
  }
}
