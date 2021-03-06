package almond

import java.nio.file.Path

import almond.protocol.KernelInfo
import ammonite.interp.{CodeClassWrapper, CodeWrapper}
import ammonite.util.Colors

import scala.concurrent.ExecutionContext

final case class ScalaInterpreterParams(
  updateBackgroundVariablesEcOpt: Option[ExecutionContext] = None,
  extraRepos: Seq[String] = Nil,
  extraBannerOpt: Option[String] = None,
  extraLinks: Seq[KernelInfo.Link] = Nil,
  predefCode: String = "",
  predefFiles: Seq[Path] = Nil,
  automaticDependencies: Map[String, Seq[String]] = Map(),
  forceMavenProperties: Map[String, String] = Map(),
  mavenProfiles: Map[String, Boolean] = Map(),
  codeWrapper: CodeWrapper = CodeClassWrapper,
  initialColors: Colors = Colors.Default,
  initialClassLoader: ClassLoader = Thread.currentThread().getContextClassLoader,
  metabrowse: Boolean = false,
  metabrowseHost: String = "localhost",
  metabrowsePort: Int = -1,
  lazyInit: Boolean = false,
  trapOutput: Boolean = false,
  disableCache: Boolean = false,
  autoUpdateLazyVals: Boolean = true,
  autoUpdateVars: Boolean = true
)
