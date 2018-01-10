package com.thoughtworks.expressions

import java.util.concurrent.atomic.AtomicInteger

/**
  * @author 杨博 (Yang Bo)
  */
trait FreshNames extends Expressions {
  // TODO: Remove this plugin, use Context.freshName instead

  protected val freshNameSeed = new AtomicInteger()

  protected def freshName(prefix: String): String = {
    val freshId: Int = freshNameSeed.getAndIncrement()
    raw"""${prefix}_$freshId"""

  }
// Disable for now due to a Scala bug   // TODO: Remove this plugin, use Context.freshName instead
//
//  protected trait ExpressionApi extends super.ExpressionApi {
//    private lazy val _name: String = freshName(super.name)
//    abstract override def name: String = _name
//  }
//
//  type Expression <: ExpressionApi

}
