package org.kowasm.web

sealed class HttpStatus (val code: Int) {

    object CONTINUE : HttpStatus(100)
    object OK : HttpStatus(200)
    object CREATED : HttpStatus(201)
    object ACCEPTED : HttpStatus(202)
    object NO_CONTENT : HttpStatus(204)

    object MOVED_PERMANENTLY : HttpStatus(301)
    object FOUND : HttpStatus(302)
    object NOT_MODIFIED : HttpStatus(304)
    object TEMPORARY_REDIRECT : HttpStatus(307)
    object PERMANENT_REDIRECT : HttpStatus(308)

    object BAD_REQUEST : HttpStatus(400)
    object UNAUTHORIZED : HttpStatus(401)
    object FORBIDDEN : HttpStatus(403)
    object NOT_FOUND : HttpStatus(404)
    object METHOD_NOT_ALLOWED : HttpStatus(405)
    object NOT_ACCEPTABLE : HttpStatus(406)

    object INTERNAL_SERVER_ERROR : HttpStatus(500)
    object SERVICE_UNAVAILABLE : HttpStatus(503)

    class Other(code: Int) : HttpStatus(code)
}
