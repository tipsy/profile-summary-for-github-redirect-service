package app

import io.javalin.Javalin

fun main(args: Array<String>) {
    Javalin.create().apply {
        before { ctx ->
            val queryString = if (ctx.queryString() != null) "?" + ctx.queryString() else ""
            ctx.redirect("https://profile-summary-for-github.com${ctx.path()}$queryString", 301)
        }
    }.start(ProcessBuilder().environment()["PORT"]?.let { Integer.parseInt(it) } ?: 0)
}
