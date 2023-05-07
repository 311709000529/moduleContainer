package com.atwsw.dataSource

import org.apache.flink.streaming.api.scala._

object repartitionTest {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    env.setParallelism(2)

    val elementData = env.fromElements(Event("Marry", "/home", 234234L), Event("Alice", "/cart", 234234523L),Event("Steve","/loft",23534543L),Event("Bob","/page_view",2342342354L))

    elementData.shuffle.print("shuffle").setParallelism(4)

    env.execute("repartitionTest")
  }

}
