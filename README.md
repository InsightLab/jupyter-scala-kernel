# Jupyter Scala Kernel

This project is a fork from [almond scala kernel](https://almond.sh/). It is configured to run a simple version of the kernel, requiring no previous install or configuration.

## Requirements:

* Python
* sbt
* Anaconda

## Installing SBT
If you do not have sbt installed at you machine, you can just download it and add to the environment PATH. If you use a Linux (or other Unix based) OS, you just have to:
* download [sbt](https://www.scala-sbt.org/download.html) zip/tar file and extract it;
* (optional) move the extract folder to the user's home directory;
* using the terminal, get inside the ```sbt/bin``` folder;
* use the command ```pwd .``` to get the absolute path of this folder;
* go to the ```.bashrc``` file, located at the home directory and add at the end of the file: ```export PATH="path/to/sbt/bin:$PATH"``` and open a new terminal;
* sbt must work perfectly now :)

## Running

To execute the kernel, just run ```./start-jupyter.sh```. **You must be inside a conda environment that contains the Jupyter Notebook installed** that will recognize the command ```jupyter notebook``` and start the notebook. The browser will open at the **user's home directory**.

The kernel will be configured with Scala 2.12.8 and the kernel option will be named *Scala (sources)*.

## To Windows users
If you have anaconda installed and sbt, you can just enter the command ```sbt jupyterStart shell```. If you do not have them and cannot/do not want to install, you can user the [Docker](https://www.docker.com/) image presented at [almond's documentation](https://almond.sh/docs/try-docker). But a warning: when this tutorial was written, there is a conflict with the *jackson-databind* package from *scala-kernel* and *spark-sql*, what does not allow the running of a Spark code at the Scala Kernel. This problem was solved at this project by excluding the *jackson-databind* package from *scala-kernel*.

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
