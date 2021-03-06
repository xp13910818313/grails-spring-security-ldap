package com.test

import grails.plugin.springsecurity.SpringSecurityService
import groovy.transform.CompileDynamic
import grails.plugin.springsecurity.annotation.Secured
import groovy.transform.CompileStatic

@CompileStatic
class SecureController {

	SpringSecurityService springSecurityService

	@Secured('IS_AUTHENTICATED_FULLY')
	def users() {
		[title: 'users', roles: renderRoles()]
	}

	@CompileDynamic
	private String renderRoles() {
		"""You have these roles: ${springSecurityService.principal.authorities.join(' ')} 
		   email: ${springSecurityService.principal.email} 
		   phone: ${springSecurityService.principal.telephone}"""
	}
}
