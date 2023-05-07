package com.atwsw.dataSource

import org.apache.flink.streaming.api.scala._


case class Event(users : String ,url : String ,timestamp: Long)

object fromElements {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    env.setParallelism(2)

    val elementData = env.fromElements(Event("Marry", "/home", 124234534534L), Event("Bob", "/home", 3456457567567L))

    val clicks = List(Event("Marry", "/home", 124234534534L), Event("Bob", "/home", 3456457567567L))


    val collectionData = env.fromCollection(clicks)


    elementData.print("fromElements")
    collectionData.print("fromCollection")

    env.execute("Job")

  }

}
