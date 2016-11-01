package net.trigyan.glide.repository.model;

import java.io.Serializable;

import org.eclipse.rdf4j.model.IRI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryModel implements Serializable {

	private boolean writable;
	private boolean readable;
	private String repositoryId;
	private String title;
	private IRI uri;
	public RepositoryModel(boolean writable, boolean readable, String repositoryId, String title, IRI uri) {
		this();
		this.writable = writable;
		this.readable = readable;
		this.repositoryId = repositoryId;
		this.title = title;
		this.uri = uri;
	}
	public RepositoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isWritable() {
		return writable;
	}
	public void setWritable(boolean writable) {
		this.writable = writable;
	}
	public boolean isReadable() {
		return readable;
	}
	public void setReadable(boolean readable) {
		this.readable = readable;
	}
	public String getRepositoryId() {
		return repositoryId;
	}
	public void setRepositoryId(String repositoryId) {
		this.repositoryId = repositoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String repositoryName) {
		this.title = repositoryName;
	}
	public IRI getUri() {
		return uri;
	}
	public void setUri(IRI uri) {
		this.uri = uri;
	}
	@Override
	public String toString() {
		return "RepositoryModel [writable=" + writable + ", readable=" + readable + ", repositoryId=" + repositoryId
				+ ", title=" + title + ", uri=" + uri + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((repositoryId == null) ? 0 : repositoryId.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RepositoryModel other = (RepositoryModel) obj;
		if (repositoryId == null) {
			if (other.repositoryId != null) {
				return false;
			}
		} else if (!repositoryId.equals(other.repositoryId)) {
			return false;
		}
		if (uri == null) {
			if (other.uri != null) {
				return false;
			}
		} else if (!uri.equals(other.uri)) {
			return false;
		}
		return true;
	}
	
	
	
	
}
