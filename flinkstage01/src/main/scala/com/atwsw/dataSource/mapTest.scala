package com.atwsw.dataSource

import org.apache.flink.api.common.functions.{MapFunction, RichMapFunction}
import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.scala._

object mapTest {


  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment


    val elementData = env.fromElements(Event("marry", "/home", 234234234L), Event("alice", "/cart", 234535345L))

    elementData.map(new RichMapFunction[Event,String] {

      override def map(in: Event): String = {
        in.users
      }

    }).print("innerClass")

    elementData.map(_.users).print("fun")


    elementData.map(new MyClass).print("class")


    env.execute("mapTest")

  }

  class MyClass extends MapFunction[Event,String] {
    override def map(t: Event): String = {
      t.users
    }
  }
}

