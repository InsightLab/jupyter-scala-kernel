
# Jupyter Scala Kernel

This project is a fork from [almond scala kernel](https://almond.sh/). It is configured to run a simple version of the kernel, requiring no previous install or configuration.

## Requirements:

* Python
* sbt
* Anaconda

## Running

To execute the kernel, just run ```./start-jupyter.sh```. You must be inside a conda environment that contains the Jupyter Notebook installed that will recognize the command ```jupyter notebook``` and start the notebook. The browser will open at the **user's home directory**.

The kernel will be configured with Scala 2.12.8 and the kernel option will be named *Scala (sources)*.

## Working with Spark

To use [Spark]([https://spark.apache.org/](https://spark.apache.org/)) you must add this two lines at the notebook:
```
import $ivy.`org.apache.spark::spark-sql:2.4.0`
import $ivy.`sh.almond::almond-spark:0.4.0`
```

Those imports will download the Spark dependencies and the *almond-spark* that enables Spark to be used at the notebook. After, to create a Spark Context, just enter:
```
import org.apache.spark.sql._

val spark = {
  NotebookSparkSession.builder()
    .master("local[*]")
    .getOrCreate()
}

val sc = spark.sparkContext
```

## Working with PySpark

To run pyspark just install it via conda: ```conda install pyspark```