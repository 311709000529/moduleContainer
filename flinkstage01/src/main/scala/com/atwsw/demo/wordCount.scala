package com.atwsw.demo

import org.apache.flink.api.scala._

object wordCount {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment

    val lineData = env.readTextFile("C:\\Users\\26939\\IdeaProjects\\moduleContainer\\flinkstage01\\src\\main\\resources\\hello.txt")

    val wordToOne = lineData.flatMap(_.split(" ")).map(word => (word, 1))

    var wordCount: AggregateDataSet[(String, Int)] = wordToOne.groupBy(0).sum(1)

    wordCount.print()
  }

}
