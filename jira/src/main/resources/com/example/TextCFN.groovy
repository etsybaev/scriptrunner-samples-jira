package com.example

import com.aval.jira.plugins.api.MyPluginComponent
import com.aval.jira.plugins.listener.CustomerDAO
import com.onresolve.jira.groovy.user.FieldBehaviours
import com.onresolve.scriptrunner.runner.ScriptRunnerImpl
import com.onresolve.scriptrunner.runner.customisers.WithPlugin

@WithPlugin("com.aval.jira.plugins.new-listener-plugin")

class TextCFN extends FieldBehaviours {

    //to find script use path com/example/TextCFN.groovy
    public run() {
        MyPluginComponent myPluginComponent = ScriptRunnerImpl.getPluginComponent(MyPluginComponent)
        CustomerDAO dao = myPluginComponent.getCustomerDAO()
        def field = getFieldByName("TextCFN")
        field.setFormValue("Some my text " + dao.get(201L).getFirstName())
    }
}
