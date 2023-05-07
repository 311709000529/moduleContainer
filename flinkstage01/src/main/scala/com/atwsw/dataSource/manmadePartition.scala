package com.atwsw.dataSource

import org.apache.flink.api.common.functions.Partitioner
import org.apache.flink.streaming.api.scala._

object manmadePartition {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val elementData = env.fromElements(Event("Marry", "/home", 124234L), Event("Alice", "/cart", 23452345L))

    val repartitonData: DataStream[Event] = elementData.partitionCustom(new Partitioner[Event] {
      override def partition(k: Event, i: Int): Int = {
        (k.timestamp % 3).toInt
      }
    }, data => data)

    repartitonData.print("repartition")


    env.execute("repartitionTest")
  }

}
