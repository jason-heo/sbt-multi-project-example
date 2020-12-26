package com.github.jasonheo

import org.scalatest.FlatSpec
import org.scalatest.Matchers._

class ClientSpec extends FlatSpec {
behavior of "Client"

  "Client" must "work" in {
    LibTestUtil.True should be (true)
  }
}
