<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:libraryTemplate pageTitle="MainPage">
    <div class="container mt-4">
        <div class="row">
            <div class="col-12 col-lg-6">
                <div class="card shadow mb-3 mt-3">
                    <div class="card-body mb-3">
                        <div class="row mt-2 p-2">
                            <div class="col-4 text-center"><img class="rounded img-fluid border shadow" src="https://images.unsplash.com/photo-1543002588-bfa74002ed7e?q=80&w=2574&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" ></div>
                            <div class="col-8">
                                <p class="bg-primary text-white p-3">Book Name<span class="text-success"></span></p>
                                <hr>
                                <p class="bg-primary text-white p-3">Author</p>
                                <hr>
                                <p class="bg-primary text-white p-3">A short description of the book would be nice here</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-6" id="form-checkout">
                <div class="card shadow mt-3">
                    <div class="card-body">
                        <h4 class="card-title">Check Out</h4>
                        <hr>
                        <p>Please enter the return date</p>
                        <div class="col-auto">
                            <label for="datepicker"></label>
                            <input type="date" id="datepicker" name="datepicker" min="2023-01-01" max="2030-12-31">
                        </div>
                        <hr>
                        <p>Please enter your legitimation number</p>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-id-badge"
                                                                                               style="font-size: 24px;"></i></span>
                            </div>
                            <input type="text">
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col mt-2">
                                <button class="btn btn-primary d-block w-100" type="button">Finish Checkout</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:libraryTemplate>
